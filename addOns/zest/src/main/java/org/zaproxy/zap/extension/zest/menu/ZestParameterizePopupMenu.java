/*
 * Zed Attack Proxy (ZAP) and its related class files.
 *
 * ZAP is an HTTP/HTTPS proxy for assessing web application security.
 *
 * Copyright 2013 The ZAP Development Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.zaproxy.zap.extension.zest.menu;

import java.awt.Component;
import org.parosproxy.paros.extension.ExtensionPopupMenuItem;
import org.zaproxy.zap.extension.httppanel.view.syntaxhighlight.HttpPanelSyntaxHighlightTextArea;
import org.zaproxy.zap.extension.script.ScriptNode;
import org.zaproxy.zap.extension.zest.ExtensionZest;
import org.zaproxy.zap.extension.zest.ZestScriptWrapper;
import org.zaproxy.zap.extension.zest.ZestZapUtils;
import org.zaproxy.zest.core.v1.ZestRequest;

public class ZestParameterizePopupMenu extends ExtensionPopupMenuItem {

    private static final long serialVersionUID = 2282358266003940700L;

    private ExtensionZest extension;
    private String replace = null;

    private ZestScriptWrapper script = null;
    private ScriptNode node = null;
    private ZestRequest request = null;

    /** This method initializes */
    public ZestParameterizePopupMenu(final ExtensionZest extension, String label) {
        super(label);
        this.extension = extension;

        this.addActionListener(
                e ->
                        extension
                                .getDialogManager()
                                .showZestParameterizeDialog(script, node, request, replace));
    }

    @Override
    public boolean isEnableForComponent(Component invoker) {
        if (invoker instanceof HttpPanelSyntaxHighlightTextArea
                && extension.getExtScript().getScriptUI() != null) {
            HttpPanelSyntaxHighlightTextArea panel = (HttpPanelSyntaxHighlightTextArea) invoker;
            ScriptNode node = extension.getExtScript().getScriptUI().getSelectedNode();
            if (node != null
                    && extension.isSelectedMessage(panel.getMessage())
                    && panel.getSelectedText() != null
                    && panel.getSelectedText().length() > 0) {
                if (ZestZapUtils.getElement(node) instanceof ZestRequest) {
                    this.request = (ZestRequest) ZestZapUtils.getElement(node);
                    this.script = extension.getZestTreeModel().getScriptWrapper(node);
                    this.node = node;
                    this.replace = panel.getSelectedText();
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public boolean isSafe() {
        return true;
    }
}
