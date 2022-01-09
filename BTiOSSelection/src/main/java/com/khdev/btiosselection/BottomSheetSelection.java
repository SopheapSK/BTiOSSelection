package com.khdev.btiosselection;

import android.app.Dialog;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class BottomSheetSelection extends BottomSheetDialogFragment {
    public static String TAG = "ChooseItemBSFragment";
    private CharSequence[] itemList;

    public static BottomSheetSelection newInstance(CharSequence[] itemList) {

        BottomSheetSelection fragment = new BottomSheetSelection();
        fragment.itemList = itemList;
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setupDialog(Dialog dialog, int style) {
        View contentView = View.inflate(getContext(), R.layout.fragment_choose_item_bottomsheet, null);
        dialog.setContentView(contentView);
        ((View) contentView.getParent()).setBackgroundColor(getResources().getColor(android.R.color.transparent));

        LinearLayout cancelLayout = dialog.findViewById(R.id.cancel_layout);
        cancelLayout.setOnClickListener(view -> dismiss());

        LinearLayout linearLayout = dialog.findViewById(R.id.item_layout);
        int padding =  requireActivity().getResources().getDimensionPixelSize(R.dimen.activity_vertical_margin);

        TypedValue outValue = new TypedValue();
        requireActivity().getTheme().resolveAttribute(android.R.attr.selectableItemBackground, outValue, true);

        LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        for (int me = 0; me < itemList.length; me++) {

            TextView textView = new TextView(requireActivity());
            textView.setLayoutParams(lparams);
            textView.setPadding(8, padding, 8, padding);
            textView.setText(itemList[me]);
            textView.setTextColor(0xFF0099D8);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
            textView.setBackgroundResource(outValue.resourceId);
            textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            int finalMe = me;
            textView.setOnClickListener(view -> {
                onMenuSelected.onSelected(finalMe);
                dismiss();
            });
            linearLayout.addView(textView);


        }
        BottomSheetDialog d = (BottomSheetDialog) getDialog();
        if (d != null) {
            d.getBehavior().setState(BottomSheetBehavior.STATE_EXPANDED);
        }

    }

    private OnMenuSelected onMenuSelected;

    public void setOnMenuSelected(OnMenuSelected onMenuSelected) {
        this.onMenuSelected = onMenuSelected;
    }

    public interface OnMenuSelected {
        void onSelected(int position);
    }

}
