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

package flylog.sdk.storage;

import java.io.Serializable;

/**
 * Object in an object storage.
 *
 * @author Dmitry Kotlyarov
 * @since 1.0
 */
public final class StorageObject implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Object key.
     */
    public final String key;

    /**
     * Object size in bytes.
     */
    public final long size;

    /**
     * Object ETag.
     */
    public final String etag;

    /**
     * Object last modification time in milliseconds.
     */
    public final long modified;

    /**
     * Constructs a storage object with specified parameters.
     *
     * @param key the object key
     * @param size the object size in bytes
     * @param etag the object ETag
     * @param modified the object last modification time in milliseconds
     */
    public StorageObject(String key, long size, String etag, long modified) {
        this.key = key;
        this.size = size;
        this.etag = etag;
        this.modified = modified;
    }
}
