/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.netbeans.modules.java.j2seproject.moduletask.classfile;

import java.io.DataInputStream;
import java.io.IOException;

/**
 *
 * @author Tomas Zezula
 */
final class Reader {
    private final DataInputStream in;

    Reader(final DataInputStream in) {
        this.in = in;
    }

    int readUnsignedByte() throws IOException {
        return 0xff & in.readByte();
    }

    int readUnsignedShort() throws IOException {
        return 0xffff & in.readShort();
    }

    long readUnsignedInt() throws IOException {
        return 0xffffffffL & in.readInt();
    }

    byte readByte() throws IOException {
        return in.readByte();
    }

    int readInt() throws IOException {
        return in.readInt();
    }
}
