// Generated by view binder compiler. Do not edit!
package com.example.btl_mxh.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.btl_mxh.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class CustomToastLayoutBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final LinearLayout customToastContainer;

  @NonNull
  public final TextView textViewToast;

  private CustomToastLayoutBinding(@NonNull LinearLayout rootView,
      @NonNull LinearLayout customToastContainer, @NonNull TextView textViewToast) {
    this.rootView = rootView;
    this.customToastContainer = customToastContainer;
    this.textViewToast = textViewToast;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static CustomToastLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CustomToastLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.custom_toast_layout, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CustomToastLayoutBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      LinearLayout customToastContainer = (LinearLayout) rootView;

      id = R.id.textViewToast;
      TextView textViewToast = ViewBindings.findChildViewById(rootView, id);
      if (textViewToast == null) {
        break missingId;
      }

      return new CustomToastLayoutBinding((LinearLayout) rootView, customToastContainer,
          textViewToast);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
