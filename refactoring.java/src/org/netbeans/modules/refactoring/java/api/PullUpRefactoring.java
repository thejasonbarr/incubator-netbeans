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
package org.netbeans.modules.refactoring.java.api;

import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import org.netbeans.api.java.source.ElementHandle;
import org.netbeans.api.java.source.TreePathHandle;
import org.netbeans.modules.refactoring.api.AbstractRefactoring;
import org.openide.util.lookup.Lookups;

/** 
 * Pull Up Refactoring
 * 
 * @see org.netbeans.modules.refactoring.spi.RefactoringPlugin
 * @see org.netbeans.modules.refactoring.spi.RefactoringPluginFactory
 * @see AbstractRefactoring
 * @see org.netbeans.modules.refactoring.api.RefactoringSession
 *
 * @author Jan Becicka
 * @author Martin Matula
 */
public final class PullUpRefactoring extends AbstractRefactoring {
    private static final MemberInfo[] EMPTY_MEMBERS = new MemberInfo[0];

    // parameters of the refactoring
    private ElementHandle targetType;
    private MemberInfo[] members;
    
    /** Creates a new instance of PullUpRefactoring 
     * @param sourceType Type the members of which should be pulled up.
     */
    public PullUpRefactoring(TreePathHandle sourceType) {
        super(Lookups.singleton(sourceType));
    }
    

    /** Returns the type the members of which should be pulled up
     * by this refactoring.
     * @return Source of the members to be pulled up.
     */
    public TreePathHandle getSourceType() {
        return getRefactoringSource().lookup(TreePathHandle.class);
    }

    // --- PARAMETERS ----------------------------------------------------------
    
    /** Returns target supertype to pull members up to.
     * @return Target supertype or null if no target supertype is set.
     */
    public ElementHandle<TypeElement> getTargetType() {
        return targetType;
    }

    /** Sets target supertype to pull members up to.
     * @param targetType Target supertype.
     */
    public void setTargetType(ElementHandle<TypeElement> targetType) {
        this.targetType = targetType;
    }

    /** Returns descriptors of the members to pull up.
     * @return Member descriptors.
     */
    public MemberInfo<ElementHandle<? extends Element>>[] getMembers() {
        // never return null
        return members == null ? EMPTY_MEMBERS : members;
    }

    /** Sets members (using their descriptors) to pull up.
     * @param members Descriptors of members to be pulled up.
     */
    public void setMembers(MemberInfo<ElementHandle<? extends Element>>[] members) {
        this.members = members;
    }
}
