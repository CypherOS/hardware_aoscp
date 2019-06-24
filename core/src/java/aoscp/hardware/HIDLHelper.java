/*
 * Copyright (C) 2019 The LineageOS Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package aoscp.hardware;

import aoscp.hardware.DisplayMode;
import aoscp.hardware.TouchscreenGesture;

import java.util.ArrayList;

class HIDLHelper {

    public static DisplayMode[] fromHIDLModes(
            ArrayList<vendor.aoscp.displayengine.V1_0.DisplayMode> modes) {
        int size = modes.size();
        DisplayMode[] r = new DisplayMode[size];
        for (int i = 0; i < size; i++) {
            vendor.aoscp.displayengine.V1_0.DisplayMode m = modes.get(i);
            r[i] = new DisplayMode(m.id, m.name);
        }
        return r;
    }

    public static DisplayMode fromHIDLMode(
            vendor.aoscp.displayengine.V1_0.DisplayMode mode) {
        return new DisplayMode(mode.id, mode.name);
    }

    static TouchscreenGesture[] fromHIDLGestures(
            ArrayList<vendor.aoscp.touch.V1_0.Gesture> gestures) {
        int size = gestures.size();
        TouchscreenGesture[] r = new TouchscreenGesture[size];
        for (int i = 0; i < size; i++) {
            vendor.aoscp.touch.V1_0.Gesture g = gestures.get(i);
            r[i] = new TouchscreenGesture(g.id, g.name, g.keycode);
        }
        return r;
    }

    static vendor.aoscp.touch.V1_0.Gesture toHIDLGesture(TouchscreenGesture gesture) {
        vendor.aoscp.touch.V1_0.Gesture g = new vendor.aoscp.touch.V1_0.Gesture();
        g.id = gesture.id;
        g.name = gesture.name;
        g.keycode = gesture.keycode;
        return g;
    }
}