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
package com.junichi11.netbeans.modules.backlog.utils;

import java.util.List;

/**
 *
 * @author junichi11
 */
public final class StringUtils {

    private StringUtils() {
    }

    /**
     * Check whether stirng is empty (empty or null).
     *
     * @param text target text
     * @return {@code true} string is empty or {@code null}, otherwise
     * {@code false}
     */
    public static boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }

    /**
     * Check whether all texts of list is empty.
     *
     * @param texts target texts
     * @return {@code true} all of strings is empty or null, otherwise
     * {@code false}
     */
    public static boolean isEmpty(List<String> texts) {
        for (String text : texts) {
            if (!isEmpty(text)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Convert to quote comment. Add "> " to the start positions of lines.
     *
     * @param text
     * @return quote comment
     */
    public static String toQuoteComment(String text) {
        if (text == null) {
            return null;
        }
        String quoteComment = "> " + text; // NOI18N
        quoteComment = quoteComment.replaceAll("\n", "\n> "); // NOI18N
        if (quoteComment.endsWith("\n> ")) { // NOI18N
            quoteComment = quoteComment.substring(0, quoteComment.length() - 2);
        }
        if (!quoteComment.endsWith("\n")) { // NOI18N
            quoteComment = quoteComment + "\n"; // NOI18N
        }
        return quoteComment;
    }
}
