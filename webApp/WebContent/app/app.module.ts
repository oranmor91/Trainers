import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { LoginComponent } from './welcome/login/login.component';
import { CreateAccountComponent } from './welcome/create-account/create-account.component';
import { WelcomeComponent } from './welcome/welcome.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import {DataService} from "./Services/data/data.service";
/*import { CoachComponent } from './coach/coach.component';*/
import {AppRoutingModule, routingComponents} from './app-routing.module';
import { HeaderComponent } from './header/header.component';
import { ProgramsComponent } from './coach/programs/programs.component';
import { WorkoutsComponent } from './coach/workouts/workouts.component';
import { ExercisesComponent } from './coach/exercises/exercises.component';
import { TrainersComponent } from './coach/trainers/trainers.component';
import { TrainerComponent } from './trainer/trainer.component';
import { CreateTrainerComponent } from './coach/trainers/create-trainer/create-trainer.component';
import { EditTrainerComponent } from './coach/trainers/edit-trainer/edit-trainer.component';
import { TrainerProgramComponent } from './coach/trainers/edit-trainer/trainer-program/trainer-program.component';
import { CreateProgramComponent } from './coach/programs/create-program/create-program.component';
import { CreateWorkoutComponent } from './coach/workouts/create-workout/create-workout.component';
import { CreateExerciseComponent } from './coach/exercises/create-exercise/create-exercise.component';
import { EditProgramComponent } from './coach/programs/edit-program/edit-program.component';
import { EditWorkoutComponent } from './coach/workouts/edit-workout/edit-workout.component';
import { EditExerciseComponent } from './coach/exercises/edit-exercise/edit-exercise.component';
import { ProfileComponent } from './trainer/profile/profile.component';
import { ProgramComponent } from './trainer/program/program.component';
import { RmComponent } from './trainer/program/rm/rm.component';
import { CurrentProgramComponent } from './trainer/program/current-program/current-program.component';
import { Profile } from 'selenium-webdriver/firefox';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    CreateAccountComponent,
    WelcomeComponent,
    routingComponents,
    HeaderComponent,
    ProgramsComponent,
    WorkoutsComponent,
    ExercisesComponent,
    TrainersComponent,
    TrainerComponent,
    CreateTrainerComponent,
    EditTrainerComponent,
    TrainerProgramComponent,
    CreateProgramComponent,
    CreateWorkoutComponent,
    CreateExerciseComponent,
    EditProgramComponent,
    EditWorkoutComponent,
    EditExerciseComponent,
    ProfileComponent,
    ProgramComponent,
    RmComponent,
    CurrentProgramComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [DataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
