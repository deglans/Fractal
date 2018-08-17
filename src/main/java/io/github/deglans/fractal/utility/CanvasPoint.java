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

package io.github.deglans.fractal.utility;

/**
 * CanvasPoint implements a point on a canvas.
 * This class is used as a box for coordinates x,y on a canvas.
 *
 * @version 0.10
 * @author Deglans Dalpasso
 */
public class CanvasPoint {

    /**
     * The x coordinate.
     */
    private final double x;

    /**
     * The y coordinate.
     */
    private final double y;

    /**
     * Create a new CanvasPoint with the given coordinate.
     *
     * @param x the x coordinate.
     * @param y the y coordinate.
     */
    public CanvasPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Create a new CanvasPoint from another CanvasPoint.
     *
     * @param p the CanvasPoint to copy.
     */
    public CanvasPoint(CanvasPoint p) {
        this.x = p.x;
        this.y = p.y;
    }

    /**
     * Return the x coordinate.
     *
     * @return the x coordinate.
     */
    public double getX() {
        return x;
    }

    /**
     * Return the y coordinate.
     *
     * @return the y coordinate.
     */
    public double getY() {
        return y;
    }

    /**
     * Return a string that represent this CanvasPoint.
     *
     * @return a string in the format (x, y).
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

}
