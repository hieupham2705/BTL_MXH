// Generated by view binder compiler. Do not edit!
package com.example.btl_mxh.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.btl_mxh.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemInfomationProfileBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView fullname;

  @NonNull
  public final ImageView imvAvatar;

  @NonNull
  public final LinearLayout linearLayout3;

  @NonNull
  public final ImageView setting;

  @NonNull
  public final TextView username;

  private ItemInfomationProfileBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView fullname, @NonNull ImageView imvAvatar, @NonNull LinearLayout linearLayout3,
      @NonNull ImageView setting, @NonNull TextView username) {
    this.rootView = rootView;
    this.fullname = fullname;
    this.imvAvatar = imvAvatar;
    this.linearLayout3 = linearLayout3;
    this.setting = setting;
    this.username = username;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemInfomationProfileBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemInfomationProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_infomation_profile, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemInfomationProfileBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.fullname;
      TextView fullname = ViewBindings.findChildViewById(rootView, id);
      if (fullname == null) {
        break missingId;
      }

      id = R.id.imv_avatar;
      ImageView imvAvatar = ViewBindings.findChildViewById(rootView, id);
      if (imvAvatar == null) {
        break missingId;
      }

      id = R.id.linearLayout3;
      LinearLayout linearLayout3 = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout3 == null) {
        break missingId;
      }

      id = R.id.setting;
      ImageView setting = ViewBindings.findChildViewById(rootView, id);
      if (setting == null) {
        break missingId;
      }

      id = R.id.username;
      TextView username = ViewBindings.findChildViewById(rootView, id);
      if (username == null) {
        break missingId;
      }

      return new ItemInfomationProfileBinding((ConstraintLayout) rootView, fullname, imvAvatar,
          linearLayout3, setting, username);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
