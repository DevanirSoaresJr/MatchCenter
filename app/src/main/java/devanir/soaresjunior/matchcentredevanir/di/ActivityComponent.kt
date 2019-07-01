package devanir.soaresjunior.matchcentredevanir.di

import dagger.Component
import devanir.soaresjunior.matchcentredevanir.ui.MatchCentreActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(matchCentreActivity: MatchCentreActivity)

}