/*
 * Copyright (c) 2018. Deglans Dalpasso <deglans@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package io.github.deglans.fractal.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

/**
 * Main GUI of FractalView.
 *
 * @version 0.11
 * @author Deglans Dalpasso
 */
public class MainGUI extends BorderPane implements Initializable {

    /**
     * Create main GUI by loading MainGUI.fxml.
     */
    public MainGUI() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/MainGUI.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        }
        catch (IOException exception) {
            System.err.println(exception.toString());
            throw new RuntimeException(exception);
        }
    }

    /**
     * Initialize MainGUI.
     * Do nothing.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
