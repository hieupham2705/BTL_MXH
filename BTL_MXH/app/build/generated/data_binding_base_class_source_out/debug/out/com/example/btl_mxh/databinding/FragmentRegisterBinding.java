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

public final class FragmentRegisterBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final BaseTextInputEditText email;

  @NonNull
  public final BaseTextInputEditText fullname;

  @NonNull
  public final ImageView imageView4;

  @NonNull
  public final TextView logIn;

  @NonNull
  public final AppCompatButton next;

  @NonNull
  public final BaseTextInputEditText phone;

  @NonNull
  public final TextView signIn;

  @NonNull
  public final TextInputLayout textInputLayout4;

  @NonNull
  public final TextInputLayout textInputLayout5;

  @NonNull
  public final TextInputLayout textInputLayout6;

  @NonNull
  public final TextInputLayout textInputLayout7;

  @NonNull
  public final TextInputLayout textInputLayoutEmail;

  @NonNull
  public final TextInputLayout textInputLayoutPhone;

  @NonNull
  public final TextView textView4;

  @NonNull
  public final TextView textView7;

  @NonNull
  public final BaseTextInputEditText username;

  private FragmentRegisterBinding(@NonNull FrameLayout rootView,
      @NonNull BaseTextInputEditText email, @NonNull BaseTextInputEditText fullname,
      @NonNull ImageView imageView4, @NonNull TextView logIn, @NonNull AppCompatButton next,
      @NonNull BaseTextInputEditText phone, @NonNull TextView signIn,
      @NonNull TextInputLayout textInputLayout4, @NonNull TextInputLayout textInputLayout5,
      @NonNull TextInputLayout textInputLayout6, @NonNull TextInputLayout textInputLayout7,
      @NonNull TextInputLayout textInputLayoutEmail, @NonNull TextInputLayout textInputLayoutPhone,
      @NonNull TextView textView4, @NonNull TextView textView7,
      @NonNull BaseTextInputEditText username) {
    this.rootView = rootView;
    this.email = email;
    this.fullname = fullname;
    this.imageView4 = imageView4;
    this.logIn = logIn;
    this.next = next;
    this.phone = phone;
    this.signIn = signIn;
    this.textInputLayout4 = textInputLayout4;
    this.textInputLayout5 = textInputLayout5;
    this.textInputLayout6 = textInputLayout6;
    this.textInputLayout7 = textInputLayout7;
    this.textInputLayoutEmail = textInputLayoutEmail;
    this.textInputLayoutPhone = textInputLayoutPhone;
    this.textView4 = textView4;
    this.textView7 = textView7;
    this.username = username;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentRegisterBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentRegisterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_register, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentRegisterBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.email;
      BaseTextInputEditText email = ViewBindings.findChildViewById(rootView, id);
      if (email == null) {
        break missingId;
      }

      id = R.id.fullname;
      BaseTextInputEditText fullname = ViewBindings.findChildViewById(rootView, id);
      if (fullname == null) {
        break missingId;
      }

      id = R.id.imageView4;
      ImageView imageView4 = ViewBindings.findChildViewById(rootView, id);
      if (imageView4 == null) {
        break missingId;
      }

      id = R.id.log_in;
      TextView logIn = ViewBindings.findChildViewById(rootView, id);
      if (logIn == null) {
        break missingId;
      }

      id = R.id.next;
      AppCompatButton next = ViewBindings.findChildViewById(rootView, id);
      if (next == null) {
        break missingId;
      }

      id = R.id.phone;
      BaseTextInputEditText phone = ViewBindings.findChildViewById(rootView, id);
      if (phone == null) {
        break missingId;
      }

      id = R.id.sign_in;
      TextView signIn = ViewBindings.findChildViewById(rootView, id);
      if (signIn == null) {
        break missingId;
      }

      id = R.id.textInputLayout4;
      TextInputLayout textInputLayout4 = ViewBindings.findChildViewById(rootView, id);
      if (textInputLayout4 == null) {
        break missingId;
      }

      id = R.id.textInputLayout5;
      TextInputLayout textInputLayout5 = ViewBindings.findChildViewById(rootView, id);
      if (textInputLayout5 == null) {
        break missingId;
      }

      id = R.id.textInputLayout6;
      TextInputLayout textInputLayout6 = ViewBindings.findChildViewById(rootView, id);
      if (textInputLayout6 == null) {
        break missingId;
      }

      id = R.id.textInputLayout7;
      TextInputLayout textInputLayout7 = ViewBindings.findChildViewById(rootView, id);
      if (textInputLayout7 == null) {
        break missingId;
      }

      id = R.id.textInputLayoutEmail;
      TextInputLayout textInputLayoutEmail = ViewBindings.findChildViewById(rootView, id);
      if (textInputLayoutEmail == null) {
        break missingId;
      }

      id = R.id.textInputLayoutPhone;
      TextInputLayout textInputLayoutPhone = ViewBindings.findChildViewById(rootView, id);
      if (textInputLayoutPhone == null) {
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

      id = R.id.username;
      BaseTextInputEditText username = ViewBindings.findChildViewById(rootView, id);
      if (username == null) {
        break missingId;
      }

      return new FragmentRegisterBinding((FrameLayout) rootView, email, fullname, imageView4, logIn,
          next, phone, signIn, textInputLayout4, textInputLayout5, textInputLayout6,
          textInputLayout7, textInputLayoutEmail, textInputLayoutPhone, textView4, textView7,
          username);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
