/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2014 Oracle and/or its affiliates. All rights reserved.
 *
 * Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common
 * Development and Distribution License("CDDL") (collectively, the
 * "License"). You may not use this file except in compliance with the
 * License. You can obtain a copy of the License at
 * http://www.netbeans.org/cddl-gplv2.html
 * or nbbuild/licenses/CDDL-GPL-2-CP. See the License for the
 * specific language governing permissions and limitations under the
 * License.  When distributing the software, include this License Header
 * Notice in each file and include the License file at
 * nbbuild/licenses/CDDL-GPL-2-CP.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the GPL Version 2 section of the License file that
 * accompanied this code. If applicable, add the following below the
 * License Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * If you wish your version of this file to be governed by only the CDDL
 * or only the GPL Version 2, indicate your decision by adding
 * "[Contributor] elects to include this software in this distribution
 * under the [CDDL or GPL Version 2] license." If you do not indicate a
 * single choice of license, a recipient has the option to distribute
 * your version of this file under either the CDDL, the GPL Version 2 or
 * to extend the choice of license to its licensees as provided above.
 * However, if you add GPL Version 2 code and therefore, elected the GPL
 * Version 2 license, then the option applies only if the new code is
 * made subject to such option by the copyright holder.
 *
 * Contributor(s):
 *
 * Portions Copyrighted 2014 Sun Microsystems, Inc.
 */
package com.junichi11.netbeans.modules.backlog.options;

import javax.swing.SpinnerNumberModel;

final class BacklogOptionsPanel extends javax.swing.JPanel {

    private static final long serialVersionUID = 1133442997630227735L;

    private final BacklogOptionsPanelController controller;
    private final SpinnerNumberModel maxIssueSpinnerNumberModel;

    BacklogOptionsPanel(BacklogOptionsPanelController controller) {
        this.controller = controller;
        initComponents();
        maxIssueSpinnerNumberModel = new SpinnerNumberModel(20, 20, 500, 10);
        maxIssueCountSpinner.setModel(maxIssueSpinnerNumberModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        defaultQueriesLabel = new javax.swing.JLabel();
        assignedToMeCheckBox = new javax.swing.JCheckBox();
        createdByMeCheckBox = new javax.swing.JCheckBox();
        maxIssueCountSpinner = new javax.swing.JSpinner();
        notificationsCheckBox = new javax.swing.JCheckBox();

        org.openide.awt.Mnemonics.setLocalizedText(defaultQueriesLabel, org.openide.util.NbBundle.getMessage(BacklogOptionsPanel.class, "BacklogOptionsPanel.defaultQueriesLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(assignedToMeCheckBox, org.openide.util.NbBundle.getMessage(BacklogOptionsPanel.class, "BacklogOptionsPanel.assignedToMeCheckBox.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(createdByMeCheckBox, org.openide.util.NbBundle.getMessage(BacklogOptionsPanel.class, "BacklogOptionsPanel.createdByMeCheckBox.text")); // NOI18N

        maxIssueCountSpinner.setToolTipText(org.openide.util.NbBundle.getMessage(BacklogOptionsPanel.class, "BacklogOptionsPanel.maxIssueCountSpinner.toolTipText")); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(notificationsCheckBox, org.openide.util.NbBundle.getMessage(BacklogOptionsPanel.class, "BacklogOptionsPanel.notificationsCheckBox.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(defaultQueriesLabel)
                        .addGap(18, 18, 18)
                        .addComponent(maxIssueCountSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(createdByMeCheckBox)
                            .addComponent(assignedToMeCheckBox)
                            .addComponent(notificationsCheckBox))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(defaultQueriesLabel)
                    .addComponent(maxIssueCountSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(assignedToMeCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(createdByMeCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(notificationsCheckBox)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    void load() {
        BacklogOptions options = BacklogOptions.getInstance();
        assignedToMeCheckBox.setSelected(options.isAssignedToMeQuery());
        createdByMeCheckBox.setSelected(options.isCreatedByMeQuery());
        setMaxIssueCount(options.getMaxIssueCountForDefaultQuery());
        notificationsCheckBox.setSelected(options.isNotificationsQuery());
    }

    void store() {
        BacklogOptions options = BacklogOptions.getInstance();
        options.setAssignedToMeQuery(isAssignedToMeQuery());
        options.setCreatedByMeQuery(isCreatedByMeQuery());
        options.setMaxIssueCountForDefaultQuery(getMaxIssueCount());
        options.setNotificationsQuery(isNotificationsQuery());
    }

    boolean valid() {
        // TODO check whether form is consistent and complete
        return true;
    }

    private boolean isAssignedToMeQuery() {
        return assignedToMeCheckBox.isSelected();
    }

    private boolean isCreatedByMeQuery() {
        return createdByMeCheckBox.isSelected();
    }

    private int getMaxIssueCount() {
        return maxIssueSpinnerNumberModel.getNumber().intValue();
    }

    private void setMaxIssueCount(int count) {
        maxIssueSpinnerNumberModel.setValue(count);
    }

    private boolean isNotificationsQuery() {
        return notificationsCheckBox.isSelected();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox assignedToMeCheckBox;
    private javax.swing.JCheckBox createdByMeCheckBox;
    private javax.swing.JLabel defaultQueriesLabel;
    private javax.swing.JSpinner maxIssueCountSpinner;
    private javax.swing.JCheckBox notificationsCheckBox;
    // End of variables declaration//GEN-END:variables
}
