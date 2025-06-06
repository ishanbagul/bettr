package lecho.lib.hellocharts.view.hack;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.viewpager.widget.ViewPager;

/**
 * Hacky fix for Issue #4 and http://code.google.com/p/android/issues/detail?id=18990
 * 
 * ScaleGestureDetector seems to mess up the touch events, which means that ViewGroups which make use of
 * onInterceptTouchEvent throw a lot of IllegalArgumentException: pointerIndex out of range.
 * 
 * There's not much I can do in my code for now, but we can mask the result by just catching the problem and ignoring
 * it.
 * 
 * @author Chris Banes
 */
public class HackyViewPager extends ViewPager {

	public HackyViewPager(Context context) {
		super(context);
	}

	public HackyViewPager(final Context context, final AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		try {
			return super.onInterceptTouchEvent(ev);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
