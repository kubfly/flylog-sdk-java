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

/**
 * Type of object storage.
 *
 * @author Dmitry Kotlyarov
 * @since 1.0
 */
public enum StorageType {
    /**
     * Google Cloud Storage.
     */
    CS("cs"),

    /**
     * Empty Local Storage.
     */
    ES("es"),

    /**
     * File System Storage.
     */
    FS("fs"),

    /**
     * Amazon S3 Storage.
     */
    S3("s3");

    /**
     * Identifier of an object storage type.
     */
    public final String id;

    StorageType(String id) {
        this.id = id;
    }
}
