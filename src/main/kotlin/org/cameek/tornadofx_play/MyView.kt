package org.cameek.tornadofx_play

import tornadofx.*

class MyView: View() {
    override val root = vbox {
        button("Press me")
        label("Waiting")
    }
}