package com.melhkptn.contactapp.feature_contact.domain.usecase

import com.melhkptn.contactapp.feature_contact.domain.model.ContactItem
import com.melhkptn.contactapp.feature_contact.domain.model.ContactRequest
import com.melhkptn.contactapp.feature_contact.domain.repository.ContactRepository
import com.melhkptn.contactapp.feature_contact.domain.usecase.base.BaseUseCase
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GetContacts @Inject constructor(
    private val repository: ContactRepository
) : BaseUseCase.RequestInteractor<GetContacts.Params, List<ContactItem>> {

    class Params(
        val page: String? = null,
        val limit: String? = null,
    ) : BaseUseCase.Params()

    override fun fetch(
        compositeDisposable: CompositeDisposable,
        postParams: Params,
        onResponse: (List<ContactItem>) -> Unit
    ): Disposable {
        return this.executeAsync(postParams)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                onResponse(it)
            },
                {
                    onResponse(
                        listOf()
                    )
                }
            )
    }

    override fun executeAsync(postParams: Params): Single<List<ContactItem>> =
        repository.getContactData(
            ContactRequest(
                page = postParams.page,
                limit = postParams.limit
            )
        )

}