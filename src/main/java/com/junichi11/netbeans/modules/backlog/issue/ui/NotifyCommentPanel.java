/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2015 Oracle and/or its affiliates. All rights reserved.
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
 * Portions Copyrighted 2015 Sun Microsystems, Inc.
 */
package com.junichi11.netbeans.modules.backlog.issue.ui;

import com.junichi11.netbeans.modules.backlog.repository.BacklogRepository;
import com.junichi11.netbeans.modules.backlog.ui.AttributesListCellRenderer;
import com.junichi11.netbeans.modules.backlog.utils.StringUtils;
import com.nulabinc.backlog4j.User;
import com.nulabinc.backlog4j.internal.json.UserJSONImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.DefaultListModel;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.util.NbBundle;

/**
 *
 * @author junichi11
 */
public class NotifyCommentPanel extends javax.swing.JPanel {

    private final DefaultListModel<User> notificationUserListModel = new DefaultListModel<>();

    /**
     * Creates new form NotifyCommentPanel
     */
    private NotifyCommentPanel(List<User> users, BacklogRepository repository) {
        initComponents();
        // set notificatoin user list
        notificationUserList.setCellRenderer(new AttributesListCellRenderer(notificationUserList.getCellRenderer(), repository.getID()));

        notificationUserListModel.addElement(new UserJSONImpl());
        for (User user : users) {
            notificationUserListModel.addElement(user);
        }
        notificationUserList.setModel(notificationUserListModel);
    }

    @NbBundle.Messages("NotifyCommentPanel.dialog.title=Notify comment to")
    public static List<Long> showDialog(List<User> users, BacklogRepository repository) {
        NotifyCommentPanel panel = new NotifyCommentPanel(users, repository);
        NotifyDescriptor.Confirmation confirmation = new NotifyDescriptor.Confirmation(
                panel,
                Bundle.NotifyCommentPanel_dialog_title(),
                NotifyDescriptor.OK_CANCEL_OPTION,
                NotifyDescriptor.PLAIN_MESSAGE
        );
        if (DialogDisplayer.getDefault().notify(confirmation) == NotifyDescriptor.OK_OPTION) {
            return panel.getNotificationUserIds();
        }
        return Collections.emptyList();
    }

    List<Long> getNotificationUserIds() {
        List<User> selectedUsers = notificationUserList.getSelectedValuesList();
        List<Long> userIds = new ArrayList<>();
        for (User selectedUser : selectedUsers) {
            if (!StringUtils.isEmpty(selectedUser.getName())) {
                userIds.add(selectedUser.getId());
            }
        }
        return userIds;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        notificationUserScrollPane = new javax.swing.JScrollPane();
        notificationUserList = new javax.swing.JList<User>();

        notificationUserScrollPane.setViewportView(notificationUserList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(notificationUserScrollPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(notificationUserScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<User> notificationUserList;
    private javax.swing.JScrollPane notificationUserScrollPane;
    // End of variables declaration//GEN-END:variables
}
