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

package flylog.sdk.storage.fs;

import flylog.sdk.storage.Storage;
import flylog.sdk.storage.StorageType;

/**
 * File System Storage abstraction layer.
 *
 * @author Dmitry Kotlyarov
 * @since 1.0
 */
public final class CustomStorage extends Storage {
    private static final long serialVersionUID = 1L;

    /**
     * Constructs File System Storage with specified parameters.
     *
     * @param type defines the storage type
     * @param endpoint defines the endpoint URL
     * @param bucket defines the bucket name
     * @param access defines the access key
     * @param secret defines the secret key
     */
    public CustomStorage(StorageType type, String endpoint, String bucket, String access, String secret) {
        super(type, endpoint, bucket, access, secret);
    }
}
