package com.example.signup.ui.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;

import com.example.signup.R;
import com.example.signup.databinding.CustomEditTextBinding;

public class CustomEditText extends RelativeLayout implements View.OnFocusChangeListener {

    private final CustomEditTextBinding binding;

    public CustomEditText(Context context) {
        this(context, null, -1);
    }

    public CustomEditText(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public CustomEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater mInflater
                = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        binding = CustomEditTextBinding.inflate(mInflater, this, true);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomEditText, defStyleAttr, 0);
        String hint = a.getString(R.styleable.CustomEditText_customHint);
        int icon = a.getResourceId(R.styleable.CustomEditText_customIcon, 0);
        int mode = a.getInt(R.styleable.CustomEditText_customMode, 2);
        int inputType = a.getInt(R.styleable.CustomEditText_customInputType, 1);

        binding.editText.setInputType(inputType);
        binding.imageView.setImageResource(icon);
        binding.textInputLayout.setEndIconMode(mode);
        binding.editText.setHint(hint);
        binding.setFocusChange(this);

        a.recycle();
    }

    public String getText() {
        return binding.editText.getText().toString();
    }

    public void setError(String error) {
        binding.editText.setError(error);
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        binding.imageView.setSelected(b);
    }

    @Override
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> container) {
        dispatchFreezeSelfOnly(container);
    }

    @Override
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        dispatchThawSelfOnly(container);
    }

    public void saveHierarchyState(SparseArray container) {
        dispatchSaveInstanceState(container);
    }

    @Nullable
    @Override
    protected Parcelable onSaveInstanceState() {
        SaveState saveState = new SaveState(super.onSaveInstanceState());
        saveState.childrenStates = saveChildViewStates();
        return saveState;
    }

    private SparseArray<Parcelable> saveChildViewStates() {
        SparseArray<Parcelable> children = new SparseArray<>();
        binding.editText.saveHierarchyState(children);
        return children;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        if (state instanceof SaveState) {
            super.onRestoreInstanceState(((SaveState) state).getSuperState());
            restoreChildViewStates(((SaveState) state).childrenStates);
        } else
            super.onRestoreInstanceState(state);
    }

    private void restoreChildViewStates(SparseArray<Parcelable> childViewStates) {
        binding.editText.restoreHierarchyState(childViewStates);
    }

    private static class SaveState extends BaseSavedState {

        Creator<SaveState> CREATOR = new Creator<SaveState>() {

            @Override
            public SaveState createFromParcel(Parcel source) {
                return new SaveState(source);
            }

            @Override
            public SaveState[] newArray(int size) {
                return new SaveState[0];
            }
        };
        private SparseArray<Parcelable> childrenStates = null;

        public SaveState(Parcel source) {
            super(source);
            childrenStates = source.readSparseArray(new ClassLoader() {
                @Override
                public Class<?> loadClass(String name) throws ClassNotFoundException {
                    return super.loadClass(name);
                }
            });
        }

        public SaveState(Parcelable superState) {
            super(superState);
        }


        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeSparseArray(childrenStates);
        }
    }

}
