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
package org.netbeans.tax.decl.parser;

import org.netbeans.tax.TreeElementDecl;
import org.netbeans.tax.decl.*;

public class ChoiceSeqParser implements ModelParser {

    /**
     */
    public TreeElementDecl.ContentType parseModel (ParserReader s) {
        TreeElementDecl.ContentType first = new ContentParticleParser ().parseModel (s);

        //determine type of parser

        if (s.trim ().startsWith ("|")) { // NOI18N
            return new ChoiceParser (first).parseModel (s);
        } else if (s.startsWith (",")) { // NOI18N
            return new SequenceParser (first).parseModel (s);
        } else {
            //(element) is treated by this
            TreeElementDecl.ContentType tmp = new SequenceParser (first).parseModel (s);
            //                first.setMultiplicity(tmp.getMultiplicity());
            return first;
        }
    }
    
}
