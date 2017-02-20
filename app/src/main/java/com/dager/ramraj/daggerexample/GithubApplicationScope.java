package com.dager.ramraj.daggerexample;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by ramraj on 20/2/17.
 */

@Scope
@Retention(RetentionPolicy.CLASS)
public @interface GithubApplicationScope {
}
