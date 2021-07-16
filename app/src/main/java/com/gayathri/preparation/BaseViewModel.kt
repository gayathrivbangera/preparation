package com.gayathri.preparation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gayathri.preparation.launchmode.TabElement
import com.gayathri.preparation.launchmode.getTabs

class BaseViewModel : ViewModel() {

    val tabElementsLiveData: LiveData<List<TabElement>> get() = _tabElementsLiveData
    private var _tabElementsLiveData: MutableLiveData<List<TabElement>> =
        MutableLiveData<List<TabElement>>()


    init {
        _tabElementsLiveData.value = getTabs
    }
}