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

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;

/**
 * Object storage abstraction layer.
 * <p>Provides operations for storing unstructured data.
 *
 * @author Dmitry Kotlyarov
 * @since 1.0
 */
public interface Storage {
    /**
     * Gets the storage type.
     *
     * @return storage type
     */
    public StorageType getType();

    /**
     * Gets the endpoint URL.
     *
     * @return endpoint URL
     */
    public String getEndpoint();

    /**
     * Gets the bucket name.
     *
     * @return bucket name
     */
    public String getBucket();

    /**
     * Gets the access key.
     *
     * @return access key
     */
    public String getAccessKey();

    /**
     * Gets the secret key.
     *
     * @return secret key
     */
    public String getSecretKey();

    /**
     * Gets the storage info.
     *
     * @return storage info
     */
    public String getInfo();

    /**
     * Gets the storage info with the specified object prefix.
     *
     * @param prefix the object prefix, can be {@code null}
     *
     * @return storage info with object prefix
     */
    public default String getInfo(String prefix) {
        return String.format("%s/%s", getInfo(), prefix);
    }

    public default StorageObject get(String key) {
        StorageObject so = find(key);
        if (so != null) {
            return so;
        } else {
            throw new ObjectStorageException(String.format("Object '%s' is not found", getInfo(key)));
        }
    }

    public default StorageObject find(String key) {
        Iterator<StorageObject> sos = list(key, 1).iterator();
        return sos.hasNext() ? sos.next() : null;
    }

    public Iterable<StorageObject> list(String prefix, int maxKeys);

    /**
     * Gets the data of the specified object as a stream.
     *
     * @param key the object key
     *
     * @return data input stream
     *
     * @throws ObjectStorageException if the object does not exist
     * @throws ConnectionStorageException if an error in connection occurs
     */
    public InputStream getData(String key);

    /**
     * Put the data to the specified object as a stream.
     *
     * @param key the object key
     *
     * @return data output stream
     *
     * @throws ObjectStorageException if the object data could not be put
     * @throws ConnectionStorageException if an error in connection occurs
     */
    public OutputStream putData(String key);

    /**
     * Gets the metadata of the specified object as a string map.
     *
     * @param key the object key
     *
     * @return metadata string map
     *
     * @throws ObjectStorageException if the object does not exist
     * @throws ConnectionStorageException if an error in connection occurs
     */
    public Map<String, String> getMeta(String key);

    /**
     * Put the metadata to the specified object as a string map.
     *
     * @param key the object key
     * @param meta the metadata
     *
     * @throws ObjectStorageException if the object metadata could not be put
     * @throws ConnectionStorageException if an error in connection occurs
     */
    public void putMeta(String key, Map<String, String> meta);
}
