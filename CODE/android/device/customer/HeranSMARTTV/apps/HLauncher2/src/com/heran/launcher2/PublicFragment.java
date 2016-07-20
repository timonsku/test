/**
 * 
 */

package com.heran.launcher2;

import com.heran.launcher2.widget.ViewBean;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorInflater;
import android.app.Fragment;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

/*
 * projectName： EosLauncher
 * moduleName： PublicFragment.java
 * @author laird.li
 * @version 1.0.0
 * @time  2013-03-19 上午11:47:59
 * @Copyright © 2016 Eos Inc.
 */

public class PublicFragment extends Fragment {

    // the flag whether the Fragment animation is running
    public boolean isRunning = false;

    public PublicFragment() {
        super();
    }

    @Override
    public void onDestroyView() {
        // TODO Auto-generated method stub
        Log.d("PublicFragment", "-----onDestroyView");
        Log.d("PublicFragment", "-----hashCode" + hashCode());
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        // TODO Auto-generated method stub
        Log.d("PublicFragment", "-----onDetach");
        super.onDetach();
    }

    @Override
    public Animator onCreateAnimator(int transit, boolean enter, int nextAnim) {
        Animator mAnimator = null;
        if (nextAnim == 0) {
            return null;
        }
        mAnimator = AnimatorInflater.loadAnimator(getActivity(), nextAnim);
        if (mAnimator != null) {
            mAnimator.addListener(new AnimatorListener() {

                @Override
                public void onAnimationStart(Animator animation) {
                    isRunning = true; // the Fragment animation is running
                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    isRunning = false; // the Fragment animation is not running
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }
            });
        }
        return mAnimator;
    }

    /**
     * add OnGlobalLayoutListener for the view
     * 
     * @param mView The view which add OnGlobalLayoutListener
     * @param mViewBean
     */
    public void addViewGlobalLayoutListener(View mView, ViewBean mViewBean) {
        ViewTreeObserver mObserver = mView.getViewTreeObserver();
        if (mObserver.isAlive()) {
            mObserver.addOnGlobalLayoutListener(new MyOnGlobalLayoutListener(mView, mViewBean));
        }
    }

    /**
     * onGlobalLayout called when the view has done onMeasure() , then draw the
     * focus view at the position of the view
     */
    class MyOnGlobalLayoutListener implements OnGlobalLayoutListener {

        private View mView;

        private ViewBean mBean;

        public MyOnGlobalLayoutListener(View view, ViewBean mBean) {
            this.mView = view;
            this.mBean = mBean;
        }

        /*
         * * (non-Javadoc)
         * @see
         * android.view.ViewTreeObserver.OnGlobalLayoutListener#onGlobalLayout()
         */

        @SuppressWarnings("deprecation")
        @Override
        public void onGlobalLayout() {
            if (mView == null || mBean == null || mBean.getmCurFocusView() == null) {
                return;
            }
            mView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            if (mView.getId() == mBean.getmCurFocusView().getId()) {
                mView.requestFocus();
                mBean.getmFocusObject().startAnimation(mView);
            }
        }
    }

}
