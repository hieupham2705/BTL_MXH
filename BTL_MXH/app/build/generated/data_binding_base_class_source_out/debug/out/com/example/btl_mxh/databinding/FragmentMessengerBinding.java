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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.btl_mxh.R;
import com.google.android.material.textfield.TextInputEditText;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentMessengerBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final ImageView buttonCall;

  @NonNull
  public final ImageView buttonImage;

  @NonNull
  public final ImageView buttonSend;

  @NonNull
  public final ImageView buttonVideoCall;

  @NonNull
  public final ConstraintLayout containerTextBox;

  @NonNull
  public final ImageView imageAvatar;

  @NonNull
  public final TextInputEditText textMessage;

  @NonNull
  public final TextView textName;

  @NonNull
  public final TextView textStatus;

  @NonNull
  public final ConstraintLayout toolBar;

  private FragmentMessengerBinding(@NonNull FrameLayout rootView, @NonNull ImageView buttonCall,
      @NonNull ImageView buttonImage, @NonNull ImageView buttonSend,
      @NonNull ImageView buttonVideoCall, @NonNull ConstraintLayout containerTextBox,
      @NonNull ImageView imageAvatar, @NonNull TextInputEditText textMessage,
      @NonNull TextView textName, @NonNull TextView textStatus, @NonNull ConstraintLayout toolBar) {
    this.rootView = rootView;
    this.buttonCall = buttonCall;
    this.buttonImage = buttonImage;
    this.buttonSend = buttonSend;
    this.buttonVideoCall = buttonVideoCall;
    this.containerTextBox = containerTextBox;
    this.imageAvatar = imageAvatar;
    this.textMessage = textMessage;
    this.textName = textName;
    this.textStatus = textStatus;
    this.toolBar = toolBar;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentMessengerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentMessengerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_messenger, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentMessengerBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button_call;
      ImageView buttonCall = ViewBindings.findChildViewById(rootView, id);
      if (buttonCall == null) {
        break missingId;
      }

      id = R.id.button_image;
      ImageView buttonImage = ViewBindings.findChildViewById(rootView, id);
      if (buttonImage == null) {
        break missingId;
      }

      id = R.id.button_send;
      ImageView buttonSend = ViewBindings.findChildViewById(rootView, id);
      if (buttonSend == null) {
        break missingId;
      }

      id = R.id.button_video_call;
      ImageView buttonVideoCall = ViewBindings.findChildViewById(rootView, id);
      if (buttonVideoCall == null) {
        break missingId;
      }

      id = R.id.container_text_box;
      ConstraintLayout containerTextBox = ViewBindings.findChildViewById(rootView, id);
      if (containerTextBox == null) {
        break missingId;
      }

      id = R.id.image_avatar;
      ImageView imageAvatar = ViewBindings.findChildViewById(rootView, id);
      if (imageAvatar == null) {
        break missingId;
      }

      id = R.id.text_message;
      TextInputEditText textMessage = ViewBindings.findChildViewById(rootView, id);
      if (textMessage == null) {
        break missingId;
      }

      id = R.id.text_name;
      TextView textName = ViewBindings.findChildViewById(rootView, id);
      if (textName == null) {
        break missingId;
      }

      id = R.id.text_status;
      TextView textStatus = ViewBindings.findChildViewById(rootView, id);
      if (textStatus == null) {
        break missingId;
      }

      id = R.id.tool_bar;
      ConstraintLayout toolBar = ViewBindings.findChildViewById(rootView, id);
      if (toolBar == null) {
        break missingId;
      }

      return new FragmentMessengerBinding((FrameLayout) rootView, buttonCall, buttonImage,
          buttonSend, buttonVideoCall, containerTextBox, imageAvatar, textMessage, textName,
          textStatus, toolBar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}