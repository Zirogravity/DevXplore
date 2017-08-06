package com.example.gravity.devxplore.screens.main.users;import android.os.Bundle;import android.support.annotation.NonNull;import android.support.v4.app.Fragment;import android.view.LayoutInflater;import android.view.View;import android.view.ViewGroup;import com.example.gravity.devxplore.R;import com.example.gravity.devxplore.data.model.User;import java.util.List;/** * Created by gravity on 7/2/17. */public class StatsFragment extends Fragment implements UserXploreContract.XploreView2, View.OnClickListener {    UserXploreContract.Presenter mPresenter;    List<User> mUsers;    public static StatsFragment newInstance() {        StatsFragment statsFragment = new StatsFragment();        return statsFragment;    }    @Override    public void onResume() {        super.onResume();        mPresenter.start();    }    @Override    public View onCreateView(LayoutInflater inflater, ViewGroup container,                             Bundle savedInstanceState) {        View view = inflater.inflate(R.layout.stats_layout, container, false);        return view;    }    @Override    public void onClick(View v) {    }    @Override    public void setPresenter(UserXploreContract.Presenter presenter) {        this.mPresenter = presenter;    }    @Override    public void showUsers(List<User> users) {        this.mUsers = users;    }    @Override    public void openUserDetails(@NonNull User viewUser) {    }}