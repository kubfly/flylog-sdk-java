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

package flylog.sdk.storage.es;

import flylog.sdk.storage.Storage;
import flylog.sdk.storage.StorageType;

import java.io.Serializable;

/**
 * Empty Local Storage abstraction layer.
 *
 * @author Dmitry Kotlyarov
 * @since 1.0
 */
public class CustomStorage implements Storage, Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Storage type.
     */
    protected final StorageType type;

    /**
     * Endpoint URL.
     */
    protected final String endpoint;

    /**
     * Bucket name.
     */
    protected final String bucket;

    /**
     * Access key.
     */
    protected final String accessKey;

    /**
     * Secret key.
     */
    protected final String secretKey;

    /**
     * Storage info.
     */
    protected final String info;

    /**
     * Constructs Empty Local Storage with the specified parameters.
     *
     * @param endpoint the endpoint URL
     * @param bucket the bucket name
     * @param accessKey the access key
     * @param secretKey the secret key
     */
    public CustomStorage(String endpoint, String bucket, String accessKey, String secretKey) {
        this.type = StorageType.ES;
        this.endpoint = endpoint;
        this.bucket = bucket;
        this.accessKey = accessKey;
        this.secretKey = secretKey;
        this.info = String.format("[%s]-[%s]: %s://%s", this.endpoint, this.accessKey, this.type, this.bucket);
    }
}
