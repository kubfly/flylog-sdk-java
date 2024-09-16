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
 * Object storage abstraction layer.
 * <p>Provides operations for storing unstructured data.
 *
 * @author Dmitry Kotlyarov
 * @since 1.0
 */
public abstract class Storage implements Serializable {
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
    protected final String access;

    /**
     * Secret key.
     */
    protected final String secret;

    /**
     * Constructs a storage with specified parameters.
     *
     * @param type defines the storage type
     * @param endpoint defines the endpoint URL
     * @param bucket defines the bucket name
     * @param access defines the access key
     * @param secret defines the secret key
     */
    protected Storage(StorageType type, String endpoint, String bucket, String access, String secret) {
        this.type = type;
        this.endpoint = endpoint;
        this.bucket = bucket;
        this.access = access;
        this.secret = secret;
    }

    /**
     * Gets the storage type.
     *
     * @return storage type
     */
    public StorageType getType() {
        return type;
    }

    /**
     * Gets the endpoint URL.
     *
     * @return endpoint URL
     */
    public String getEndpoint() {
        return endpoint;
    }

    /**
     * Gets the bucket name.
     *
     * @return bucket name
     */
    public String getBucket() {
        return bucket;
    }

    /**
     * Gets the access key.
     *
     * @return access key
     */
    public String getAccess() {
        return access;
    }

    /**
     * Gets the secret key.
     *
     * @return secret key
     */
    public String getSecret() {
        return secret;
    }
}
