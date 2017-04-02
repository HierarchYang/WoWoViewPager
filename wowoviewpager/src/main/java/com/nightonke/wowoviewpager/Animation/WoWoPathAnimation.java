package com.nightonke.wowoviewpager.Animation;

import android.view.View;

import com.nightonke.wowoviewpager.Enum.Ease;
import com.nightonke.wowoviewpager.WoWoPathView;

/**
 * Created by Weiping Huang at 19:56 on 2016/3/3
 * For Personal Open Source
 * Contact me at 2584541288@qq.com or nightonke@outlook.com
 * For more projects: https://github.com/Nightonke
 *
 * Animation to perform a moving path with a image-head.
 */

public class WoWoPathAnimation extends PageAnimation {

    private WoWoPathView pathView;

    public WoWoPathAnimation(int page, float startOffset, float endOffset, Ease ease, boolean useSameEaseEnumBack, WoWoPathView pathView) {
        super(page, startOffset, endOffset, ease, useSameEaseEnumBack);
        this.pathView = pathView;
    }

    @Override
    protected void toStartState(View view) {
        pathView.toStartState();
    }

    @Override
    protected void toMiddleState(View view, float offset) {
        pathView.toMiddleState(offset);
    }

    @Override
    protected void toEndState(View view) {
        pathView.toEndState();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends PageAnimation.Builder<WoWoPathAnimation.Builder> {

        private WoWoPathView pathView = null;

        public Builder path(WoWoPathView pathView) {
            this.pathView = pathView;
            return this;
        }

        public WoWoPathAnimation build() {
            checkUninitializedAttributes();
            return new WoWoPathAnimation(page, startOffset, endOffset, ease, useSameEaseEnumBack, pathView);
        }

        @Override
        protected void checkUninitializedAttributes() {
            if (pathView == null) uninitializedAttributeException("pathView");
        }
    }
}
