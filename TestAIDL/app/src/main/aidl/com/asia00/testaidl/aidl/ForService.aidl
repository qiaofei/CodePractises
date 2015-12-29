// ForService.aidl
package com.asia00.testaidl.aidl;
import com.asia00.testaidl.aidl.ForActivity;
// Declare any non-default types here with import statements

interface ForService {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
            void registerTestCall(ForActivity fa);
            void involkCallBack();
}
