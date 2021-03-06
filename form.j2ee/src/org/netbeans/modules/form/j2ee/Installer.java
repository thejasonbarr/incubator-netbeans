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
package org.netbeans.modules.form.j2ee;

import org.netbeans.modules.form.CreationDescriptor;
import org.netbeans.modules.form.CreationFactory;
import org.openide.modules.ModuleInstall;

/**
 * Management of form/j2ee module's lifecycle.
 *
 * @author Jan Stola
 */
public class Installer extends ModuleInstall {
    
    /**
     * Registers creation descriptors.
     */
    @Override
    public void restored() {
        // Install creator for EntityManager
        CreationDescriptor cd = new CreationDescriptor() {
            @Override
            public String getDescribedClassName() {
                return "javax.persistence.EntityManager";  // NOI18N
            }
        };
        cd.addCreator(new EntityManagerCreator(), new Object[] {"pu"}); // NOI18N
        CreationFactory.registerDescriptor(cd);

        // Install creator for Query
        cd = new CreationDescriptor() {
            @Override
            public String getDescribedClassName() {
                return "javax.persistence.Query";  // NOI18N
            }
        };
        cd.addCreator(new QueryCreator(), new Object[] {null, null, 0, -1}); // NOI18N
        CreationFactory.registerDescriptor(cd);

        cd = CreationFactory.getDescriptor(java.util.List.class);
        if (cd == null) {
            cd = new CreationDescriptor() {
                @Override
                public Class getDescribedClass() {
                    return java.util.List.class;
                }
            };
            CreationFactory.registerDescriptor(cd);
        }
        cd.addCreator(new QueryResultListCreator(), new Object[] {null, false, false});
    }
    
}
