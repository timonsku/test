LOCAL_PATH:= $(call my-dir)

#----------------------------------------------------------------------
include $(CLEAR_VARS)

LOCAL_MODULE_TAGS := optional

LOCAL_MODULE := libWnnJpnDic_scifly

LOCAL_SRC_FILES := \
	WnnJpnDic.c

LOCAL_SHARED_LIBRARIES := 

LOCAL_STATIC_LIBRARIES :=

LOCAL_C_INCLUDES += \
	$(LOCAL_PATH)/../libwnnDictionary/include

LOCAL_CFLAGS += \
	-O

include $(BUILD_SHARED_LIBRARY)
