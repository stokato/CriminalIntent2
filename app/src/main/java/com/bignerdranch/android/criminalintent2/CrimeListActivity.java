package com.bignerdranch.android.criminalintent2;

import android.support.v4.app.Fragment;

/**
 * Created by @s.t.o.k.a.t.o on 24.01.2017.
 */

public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
