/*
 * Copyright 2014 Feng Dai
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

package com.fragmentmaster.sample.pageanimator;

import android.view.View;

import com.fragmentmaster.animator.PageAnimator;

public class VerticalSlideAnimator extends PageAnimator {
    private static final float MIN_SCALE = 0.85f;
    private static final float MIN_ALPHA = 0.5f;

    @Override
    protected void transformBackgroundPage(View page, float position,
                                           boolean enter) {
        int pageWidth = page.getWidth();

        // Counteract the default slide transition
        page.setTranslationX(pageWidth * -position);

        // Fade the page out (between MIN_ALPHA and 1)
        page.setAlpha(MIN_ALPHA + (1 - MIN_ALPHA) * (1 + position));

        // Scale the page down (between MIN_SCALE and 1)
        float scaleFactor = MIN_SCALE + (1 - MIN_SCALE) * (1 + position);
        page.setScaleX(scaleFactor);
        page.setScaleY(scaleFactor);
    }

    @Override
    protected void transformForegroundPage(View page, float position,
                                           boolean enter) {
        int pageWidth = page.getWidth();
        int pageHeight = page.getHeight();
        page.setTranslationX(pageWidth * -position);
        page.setTranslationY(pageHeight * position);
        page.setAlpha(1);
        page.setScaleX(1);
        page.setScaleY(1);
    }
}
