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

package org.netbeans.modules.languages.features;

import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Action which shows TokensBrowser component.
 */
public class TokensBrowserAction extends AbstractAction {
    
    public TokensBrowserAction () {
        super (NbBundle.getMessage (TokensBrowserAction.class, "CTL_TokensBrowserAction"));
//        putValue(SMALL_ICON, new ImageIcon(Utilities.loadImage(TokensBrowserTopComponent.ICON_PATH, true)));
    }
    
    public void actionPerformed (ActionEvent evt) {
        TopComponent win = TokensBrowserTopComponent.findInstance ();
        win.open ();
        win.requestActive ();
    }
    
}
