// Generated by view binder compiler. Do not edit!
package com.example.btl_mxh.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.btl_mxh.R;
import com.example.btl_mxh.base.BaseTextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentRegisterPasswordBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final AppCompatButton create;

  @NonNull
  public final ImageView imageView4;

  @NonNull
  public final BaseTextInputEditText password;

  @NonNull
  public final BaseTextInputEditText passwordAgain;

  @NonNull
  public final TextView signIn;

  @NonNull
  public final TextInputLayout textInputLayout1;

  @NonNull
  public final TextInputLayout textInputLayout2;

  @NonNull
  public final TextView textView4;

  @NonNull
  public final TextView textView7;

  @NonNull
  public final TextView tvErrorCondition;

  @NonNull
  public final TextView tvErrorJoint;

  private FragmentRegisterPasswordBinding(@NonNull FrameLayout rootView,
      @NonNull AppCompatButton create, @NonNull ImageView imageView4,
      @NonNull BaseTextInputEditText password, @NonNull BaseTextInputEditText passwordAgain,
      @NonNull TextView signIn, @NonNull TextInputLayout textInputLayout1,
      @NonNull TextInputLayout textInputLayout2, @NonNull TextView textView4,
      @NonNull TextView textView7, @NonNull TextView tvErrorCondition,
      @NonNull TextView tvErrorJoint) {
    this.rootView = rootView;
    this.create = create;
    this.imageView4 = imageView4;
    this.password = password;
    this.passwordAgain = passwordAgain;
    this.signIn = signIn;
    this.textInputLayout1 = textInputLayout1;
    this.textInputLayout2 = textInputLayout2;
    this.textView4 = textView4;
    this.textView7 = textView7;
    this.tvErrorCondition = tvErrorCondition;
    this.tvErrorJoint = tvErrorJoint;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentRegisterPasswordBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentRegisterPasswordBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_register_password, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentRegisterPasswordBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.create;
      AppCompatButton create = ViewBindings.findChildViewById(rootView, id);
      if (create == null) {
        break missingId;
      }

      id = R.id.imageView4;
      ImageView imageView4 = ViewBindings.findChildViewById(rootView, id);
      if (imageView4 == null) {
        break missingId;
      }

      id = R.id.password;
      BaseTextInputEditText password = ViewBindings.findChildViewById(rootView, id);
      if (password == null) {
        break missingId;
      }

      id = R.id.password_again;
      BaseTextInputEditText passwordAgain = ViewBindings.findChildViewById(rootView, id);
      if (passwordAgain == null) {
        break missingId;
      }

      id = R.id.sign_in;
      TextView signIn = ViewBindings.findChildViewById(rootView, id);
      if (signIn == null) {
        break missingId;
      }

      id = R.id.textInputLayout1;
      TextInputLayout textInputLayout1 = ViewBindings.findChildViewById(rootView, id);
      if (textInputLayout1 == null) {
        break missingId;
      }

      id = R.id.textInputLayout2;
      TextInputLayout textInputLayout2 = ViewBindings.findChildViewById(rootView, id);
      if (textInputLayout2 == null) {
        break missingId;
      }

      id = R.id.textView4;
      TextView textView4 = ViewBindings.findChildViewById(rootView, id);
      if (textView4 == null) {
        break missingId;
      }

      id = R.id.textView7;
      TextView textView7 = ViewBindings.findChildViewById(rootView, id);
      if (textView7 == null) {
        break missingId;
      }

      id = R.id.tv_error_condition;
      TextView tvErrorCondition = ViewBindings.findChildViewById(rootView, id);
      if (tvErrorCondition == null) {
        break missingId;
      }

      id = R.id.tv_error_joint;
      TextView tvErrorJoint = ViewBindings.findChildViewById(rootView, id);
      if (tvErrorJoint == null) {
        break missingId;
      }

      return new FragmentRegisterPasswordBinding((FrameLayout) rootView, create, imageView4,
          password, passwordAgain, signIn, textInputLayout1, textInputLayout2, textView4, textView7,
          tvErrorCondition, tvErrorJoint);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
