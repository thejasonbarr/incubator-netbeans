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
package org.netbeans.modules.bugtracking.issuetable;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Tomas Stupka
 */
class FindInQueryBar extends javax.swing.JPanel {
    private static final int MAX_SEARCH_MODEL_SIZE = 5;
    private FindInQuerySupport support;
    private boolean initialized;
    private DefaultComboBoxModel lastSearchModel;

    FindInQueryBar(FindInQuerySupport support) {
        this.support = support;
        initComponents();
        lastSearchModel = new DefaultComboBoxModel();
        findCombo.setModel(lastSearchModel);
        findCombo.setSelectedItem(""); // NOI18N
        initialized = true;
        addComboEditorListener();
        InputMap inputMap = getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        String closeKey = "close"; // NOI18N
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), closeKey);
        getActionMap().put(closeKey, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FindInQueryBar.this.support.cancel();
            }
        });
    }

    private void addComboEditorListener() {
        Component editor = findCombo.getEditor().getEditorComponent();
        if (editor instanceof JTextComponent) {
            JTextComponent tcomp = (JTextComponent)editor;
            tcomp.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    changedUpdate(e);
                }
                @Override
                public void removeUpdate(DocumentEvent e) {
                    changedUpdate(e);
                }
                @Override
                public void changedUpdate(DocumentEvent e) {
                    support.updatePattern();
                }
            });
        }
    }

    String getText() {
        return findCombo.getEditor().getItem().toString();
    }

    boolean getMatchCase() {
        return machCaseChoice.isSelected();
    }

    boolean getWholeWords() {
        return wholeWordsChoice.isSelected();
    }

    boolean getRegularExpression() {
        return regularExpressionChoice.isSelected();
    }

    boolean getHighlightResults() {
        return highlightResultsChoice.isSelected();
    }

    @Override
    public boolean requestFocusInWindow() {
        return findCombo.requestFocusInWindow();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        findLabel = new javax.swing.JLabel();
        findCombo = new javax.swing.JComboBox();
        machCaseChoice = new javax.swing.JCheckBox();
        closeButton = new javax.swing.JButton();
        wholeWordsChoice = new javax.swing.JCheckBox();
        regularExpressionChoice = new javax.swing.JCheckBox();
        highlightResultsChoice = new javax.swing.JCheckBox();

        findLabel.setText(org.openide.util.NbBundle.getMessage(FindInQueryBar.class, "FindInQueryBar.findLabel.text")); // NOI18N

        findCombo.setEditable(true);
        findCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findComboActionPerformed(evt);
            }
        });

        machCaseChoice.setText(org.openide.util.NbBundle.getMessage(FindInQueryBar.class, "FindInQueryBar.machCaseChoice.text")); // NOI18N
        machCaseChoice.setFocusable(false);
        machCaseChoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                machCaseChoiceActionPerformed(evt);
            }
        });

        closeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/netbeans/modules/bugtracking/commons/resources/find_close.png"))); // NOI18N
        closeButton.setBorderPainted(false);
        closeButton.setContentAreaFilled(false);
        closeButton.setFocusable(false);
        closeButton.setMargin(new java.awt.Insets(2, 1, 0, 1));
        closeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeButtonMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeButtonMouseEntered(evt);
            }
        });
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        wholeWordsChoice.setText(org.openide.util.NbBundle.getMessage(FindInQueryBar.class, "FindInQueryBar.wholeWordsChoice.text")); // NOI18N
        wholeWordsChoice.setFocusable(false);
        wholeWordsChoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wholeWordsChoiceActionPerformed(evt);
            }
        });

        regularExpressionChoice.setText(org.openide.util.NbBundle.getMessage(FindInQueryBar.class, "FindInQueryBar.regularExpressionChoice.text")); // NOI18N
        regularExpressionChoice.setFocusable(false);
        regularExpressionChoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regularExpressionChoiceActionPerformed(evt);
            }
        });

        highlightResultsChoice.setText(org.openide.util.NbBundle.getMessage(FindInQueryBar.class, "FindInQueryBar.highlightResultsChoice.text")); // NOI18N
        highlightResultsChoice.setFocusable(false);
        highlightResultsChoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                highlightResultsChoiceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(findLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(findCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(machCaseChoice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(wholeWordsChoice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(regularExpressionChoice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(highlightResultsChoice)
                .addGap(41, 41, 41)
                .addComponent(closeButton))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(findLabel)
                .addComponent(findCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(machCaseChoice)
                .addComponent(wholeWordsChoice)
                .addComponent(regularExpressionChoice)
                .addComponent(highlightResultsChoice))
            .addComponent(closeButton)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMouseEntered
        processMouseEvent(evt, true);
    }//GEN-LAST:event_closeButtonMouseEntered

    private void closeButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMouseExited
        processMouseEvent(evt, false);
    }//GEN-LAST:event_closeButtonMouseExited

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        support.cancel();
    }//GEN-LAST:event_closeButtonActionPerformed

    private void findComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findComboActionPerformed
        if (initialized && isVisible()) {
            updateComboModel();
            support.updatePattern();
        }
    }//GEN-LAST:event_findComboActionPerformed

    private void machCaseChoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_machCaseChoiceActionPerformed
        support.updatePattern();
    }//GEN-LAST:event_machCaseChoiceActionPerformed

    private void wholeWordsChoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wholeWordsChoiceActionPerformed
        support.updatePattern();
    }//GEN-LAST:event_wholeWordsChoiceActionPerformed

    private void regularExpressionChoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regularExpressionChoiceActionPerformed
        wholeWordsChoice.setEnabled(!regularExpressionChoice.isSelected());
        support.updatePattern();
    }//GEN-LAST:event_regularExpressionChoiceActionPerformed

    private void highlightResultsChoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_highlightResultsChoiceActionPerformed
        support.switchHighlight(highlightResultsChoice.isSelected());
    }//GEN-LAST:event_highlightResultsChoiceActionPerformed

    private void processMouseEvent(MouseEvent evt, boolean over) {
        Object src = evt.getSource();
        if (src instanceof JButton) {
            JButton button = (JButton)src;
            button.setContentAreaFilled(over);
            button.setBorderPainted(over);
        }
    }

    private void updateComboModel() {
        String pattern = getText();
        int idx = -1;
        for (int i=0; i<lastSearchModel.getSize(); i++) {
            if (pattern.equals(lastSearchModel.getElementAt(i))) {
                idx = i;
            }
        }
        if (idx != 0) {
            if (idx != -1) {
                lastSearchModel.removeElementAt(idx);
            }
            lastSearchModel.insertElementAt(pattern, 0);
            if (lastSearchModel.getSize() > MAX_SEARCH_MODEL_SIZE) {
                lastSearchModel.removeElementAt(MAX_SEARCH_MODEL_SIZE);
            }
            findCombo.setSelectedItem(pattern);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JComboBox findCombo;
    private javax.swing.JLabel findLabel;
    private javax.swing.JCheckBox highlightResultsChoice;
    private javax.swing.JCheckBox machCaseChoice;
    private javax.swing.JCheckBox regularExpressionChoice;
    private javax.swing.JCheckBox wholeWordsChoice;
    // End of variables declaration//GEN-END:variables
    
}
