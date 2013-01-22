/*
 * Copyright (c) 2012, ScalaFX Project
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the ScalaFX Project nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE SCALAFX PROJECT OR ITS CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package scalafx.controls.controls

import javafx.scene.layout.Priority
import javafx.scene.text.TextAlignment
import scalafx.Includes.jfxBooleanProperty2sfx
import scalafx.Includes.jfxLabeled2sfx
import scalafx.Includes.jfxReadOnlyObjectProperty2sfx
import scalafx.Includes.jfxReadOnlyStringProperty2sfx
import scalafx.Includes.jfxStringProperty2sfx
import scalafx.scene.Node.sfxNode2jfx
import scalafx.scene.control.CheckBox.sfxCheckBox2jfx
import scalafx.scene.control.Label.sfxLabel2jfx
import scalafx.scene.control.CheckBox
import scalafx.scene.control.Label
import scalafx.scene.control.TextInputControl
import scalafx.scene.control.TitledPane
import scalafx.scene.layout.GridPane.sfxGridPane2jfx
import scalafx.scene.layout.GridPane
import scalafx.scene.Node

class TextInputControlControls(target: TextInputControl) extends PropertiesNodes[TextInputControl](target, "TextInputControl Properties") {

  val chbEditable = new CheckBox {
    selected <==> target.editable
    text = "Editable"
  }

  val lblAnchor = new Label {
    text <== target.anchor.asString
  }

  val lblCaretPosition = new Label {
    text <== target.caretPosition.asString
  }

  val lblLength = new Label {
    text <== target.length.asString
  }

  val lblSelectedTextLength = new Label
  target.selectedText.onChange(lblSelectedTextLength.text = target.selectedText.get.length.toString)

  val lblSelection = new Label
  target.selection.onChange(lblSelection.text = target.selection.value.toString)

  super.addNode("Anchor", lblAnchor)
  super.addNode("Caret Position", lblCaretPosition)
  super.addNode("Length", lblLength)
  super.addNode("Selected Text Length", lblSelectedTextLength)
  super.addNode("Selection", lblSelection)

}