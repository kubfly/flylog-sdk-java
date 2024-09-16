/*
 * Copyright 2024 The FlyLog Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package flylog.sdk.utility.concurrent;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Controls multi-threaded access to a given resource using atomics instead of locks.
 * <p>Multiple threads access a resource while thread section is enabled.
 * <p>An external thread can disable thread section at any time and terminate threads access to the resource.
 * <p>Then it can enable thread section and resume threads access to the resource.
 *
 * @author Dmitry Kotlyarov
 * @since 1.0
 */
public final class ThreadSection {
    private final AtomicBoolean enabled;
    private final AtomicLong count = new AtomicLong(0L);

    /**
     * Constructs a thread section with the specified state.
     *
     * @param enabled defines the state of a thread section {@code true} - enabled or {@code false} - disabled
     */
    public ThreadSection(boolean enabled) {
        this.enabled = new AtomicBoolean(enabled);
    }

    /**
     * Returns {@code true} if this thread section is in the enabled state, {@code false} otherwise.
     *
     * @return {@code true} if this thread section is in the enabled state, {@code false} otherwise
     */
    public boolean isEnabled() {
        return enabled.get();
    }

    /**
     * Returns {@code true} if this thread section is in the disabled state, {@code false} otherwise.
     *
     * @return {@code true} if this thread section is in the disabled state, {@code false} otherwise
     */
    public boolean isDisabled() {
        return !enabled.get() && (count.get() == 0L);
    }

    /**
     * Enables this thread section.
     *
     * @return {@code true} if this thread section was switched to the enabled state, {@code false} if it was already in the enabled state
     */
    public boolean enable() {
        return enabled.compareAndSet(false, true);
    }

    /**
     * Disables this thread section.
     *
     * @return {@code true} if this thread section was switched to the disabled state, {@code false} if it was already in the disabled state
     */
    public boolean disable() {
        return enabled.compareAndSet(true, false);
    }

    /**
     * Waits until this thread section becomes disabled and all access threads have left it.
     */
    public void await() {
        while (!isDisabled()) {
            Thread.onSpinWait();
        }
    }

    /**
     * Enters this thread section with the access thread.
     * <p>After every call of this method with {@code true} result should follow the call of {@link #leave() leave} method.
     *
     * @return {@code true} if this thread section is enabled, {@code false} if it is disabled
     */
    public boolean enter() {
        if (enabled.get()) {
            count.incrementAndGet();
            if (enabled.get()) {
                return true;
            } else {
                count.decrementAndGet();
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Leaves this thread section with the access thread.
     * <p>Every call of this method should follow after the call of {@link #enter() enter} method with {@code true} result.
     */
    public void leave() {
        long c = count.decrementAndGet();
        if (c < 0L) {
            count.incrementAndGet();
            throw new IllegalStateException(String.format("Illegal enter/leave calls: %d", c));
        }
    }
}
