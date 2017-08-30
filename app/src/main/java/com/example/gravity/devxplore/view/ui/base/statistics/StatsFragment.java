package com.example.gravity.devxplore.view.ui.base.statistics;import android.arch.lifecycle.LifecycleRegistry;import android.arch.lifecycle.LifecycleRegistryOwner;import android.os.Bundle;import android.support.annotation.NonNull;import android.support.v4.app.Fragment;import android.view.LayoutInflater;import android.view.View;import android.view.ViewGroup;import com.example.gravity.devxplore.R;import com.example.gravity.devxplore.data.model.Repository;import com.example.gravity.devxplore.data.model.User;import java.util.List;/** * Created by gravity on 7/2/17. */public class StatsFragment extends Fragment implements LifecycleRegistryOwner, View.OnClickListener {    private List<Repository> mRepositories;    private List<User> mUsers;    private final LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);    @Override    public LifecycleRegistry getLifecycle() {        return lifecycleRegistry;    }    @NonNull    public static StatsFragment newInstance() {        StatsFragment statsFragment = new StatsFragment();        return statsFragment;    }    @Override    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,                             Bundle savedInstanceState) {        View view = inflater.inflate(R.layout.fragment_statistics, container, false);        return view;    }    @Override    public void onClick(View v) {    }}