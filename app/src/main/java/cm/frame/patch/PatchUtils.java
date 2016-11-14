package cm.frame.patch;

import android.util.Log;

/**
 * Created by zhouxiqing on 2016/11/14.
 */
public class PatchUtils {
    private static boolean canPatch;
    public static final int PATCH_SUCCESS = 0;
    public static final int PATCH_FAIL = -1;

    static {
        try {
            System.loadLibrary("ApkPatch");
            canPatch = true;
        } catch (Throwable localThrowable) {
            canPatch = false;
            System.out.println("loadLibrary : libApkPatch.so fail");
        }
    }

    /**
     * @param oldApkPath Absolute path of old file
     * @param newApkPath Absolute path of new file
     * @param patchPath  Absolute path of patch files
     * @return return zero for success, anything else for failure.
     */
    public static int bspatch(String oldApkPath, String newApkPath,
                              String patchPath) {
        if (canPatch)
            try {
                return patch(oldApkPath, newApkPath, patchPath);
            } catch (Throwable localThrowable) {
                Log.e("", "", localThrowable);
                return PATCH_FAIL;
            }
        return PATCH_FAIL;
    }

    public static boolean canPatch() {
        return canPatch;
    }

    public static native int patch(String oldApkPath, String newApkPath,
                                   String patchPath);
}
