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
package org.netbeans.jellytools.modules.debugger.actions;

import org.netbeans.jellytools.Bundle;
import org.netbeans.jellytools.MainWindowOperator;
import org.netbeans.jellytools.actions.Action;
import org.netbeans.jemmy.EventTool;

/**
 * Used to call "Debug|Take GUI Snapshot" main menu item.
 *
 * @see org.netbeans.jellytools.actions.Action
 * @author Jiri Kovalsky
 */
public class TakeGUISnapshotAction extends Action {

    // "Debug|Take GUI Snapshot"
    private static final String mainMenuPath =
            Bundle.getStringTrimmed("org.netbeans.modules.project.ui.Bundle", "Menu/RunProject")
            + "|"
            + Bundle.getStringTrimmed("org.netbeans.modules.debugger.jpda.visual.Bundle", "CTL_TakeScreenshotAction");

    /** Creates new TakeGUISnapshotAction instance. */
    public TakeGUISnapshotAction() {
        super(mainMenuPath, null);
    }

    /** Performs action through main menu. */
    @Override
    public void performMenu() {
        // This is a workaround of issue 70731 (Main menu item not enabled when already shown)
        for (int i = 0; i < 10; i++) {
            if (MainWindowOperator.getDefault().menuBar().showMenuItem(mainMenuPath).isEnabled()) {
                break;
            }
            MainWindowOperator.getDefault().menuBar().closeSubmenus();
            new EventTool().waitNoEvent(300);
        }
        super.performMenu();
    }
}