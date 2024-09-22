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
import flylog.sdk.storage.StorageObject;
import flylog.sdk.storage.StorageType;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Map;

/**
 * File System Storage abstraction layer.
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

    /**
     * Gets the storage type.
     *
     * @return storage type
     */
    @Override
    public StorageType getType() {
        return null;
    }

    /**
     * Gets the endpoint URL.
     *
     * @return endpoint URL
     */
    @Override
    public String getEndpoint() {
        return "";
    }

    /**
     * Gets the bucket name.
     *
     * @return bucket name
     */
    @Override
    public String getBucket() {
        return "";
    }

    /**
     * Gets the access key.
     *
     * @return access key
     */
    @Override
    public String getAccessKey() {
        return "";
    }

    /**
     * Gets the secret key.
     *
     * @return secret key
     */
    @Override
    public String getSecretKey() {
        return "";
    }

    /**
     * Gets the storage info.
     *
     * @return storage info
     */
    @Override
    public String getInfo() {
        return "";
    }

    /**
     * Iterates over the storage objects with the specified prefix.
     *
     * @param prefix  the objects prefix
     * @param maxKeys the number of storage object keys in one request
     * @return iterable with storage objects
     * @throws ConnectionStorageException if an error in connection occurs
     */
    @Override
    public Iterable<StorageObject> list(String prefix, int maxKeys) {
        return null;
    }

    /**
     * Gets the data of the specified object as a stream.
     *
     * @param key the object key
     * @return data input stream
     * @throws ObjectStorageException     if the object does not exist
     * @throws ConnectionStorageException if an error in connection occurs
     */
    @Override
    public InputStream getData(String key) {
        return null;
    }

    /**
     * Put the data to the specified object as a stream.
     *
     * @param key the object key
     * @return data output stream
     * @throws ObjectStorageException     if the object data could not be put
     * @throws ConnectionStorageException if an error in connection occurs
     */
    @Override
    public OutputStream putData(String key) {
        return null;
    }

    /**
     * Gets the metadata of the specified object as a string map.
     *
     * @param key the object key
     * @return metadata string map
     * @throws ObjectStorageException     if the object does not exist
     * @throws ConnectionStorageException if an error in connection occurs
     */
    @Override
    public Map<String, String> getMeta(String key) {
        return Map.of();
    }

    /**
     * Put the metadata to the specified object as a string map.
     *
     * @param key  the object key
     * @param meta the metadata
     * @throws ObjectStorageException     if the object metadata could not be put
     * @throws ConnectionStorageException if an error in connection occurs
     */
    @Override
    public void putMeta(String key, Map<String, String> meta) {
    }
}
