package com.example.testservice;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.os.Build;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;

import static android.accessibilityservice.AccessibilityServiceInfo.CAPABILITY_CAN_PERFORM_GESTURES;

public class TestService extends AccessibilityService {

    private static final String TAG = TestService.class.getSimpleName();

    public TestService() {
        super();
        Log.d(TAG, "TestService");
    }

    @Override
    protected void onServiceConnected() {

        Log.d(TAG, "onServiceConnected");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            final AccessibilityServiceInfo info = getServiceInfo();
            final int capabilities = info.getCapabilities();
            Log.d(TAG, "flags=0x" + Integer.toHexString(capabilities));
            Log.d(TAG, "canPerformGestures=" +
                    ((capabilities & CAPABILITY_CAN_PERFORM_GESTURES) != 0x0));
        }

    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        Log.d(TAG, event.toString());
    }

    @Override
    public void onInterrupt() {
        Log.d(TAG, "onInterrupt");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

}
