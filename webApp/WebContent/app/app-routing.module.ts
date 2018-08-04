import {NgModule} from "@angular/core";
import {Routes, RouterModule} from "@angular/router";
import {CoachComponent} from './coach/coach.component';
import {WelcomeComponent} from "./welcome/welcome.component";
import {ProgramsComponent} from "./coach/programs/programs.component";
import {CreateProgramComponent} from "./coach/programs/create-program/create-program.component";
import {WorkoutsComponent} from "./coach/workouts/workouts.component";
import {CreateWorkoutComponent} from "./coach/workouts/create-workout/create-workout.component";
import {ExercisesComponent} from "./coach/exercises/exercises.component";
import {CreateExerciseComponent} from "./coach/exercises/create-exercise/create-exercise.component";
import { EditExerciseComponent } from './coach/exercises/edit-exercise/edit-exercise.component';
import { EditProgramComponent } from './coach/programs/edit-program/edit-program.component';
import {TrainersComponent} from "./coach/trainers/trainers.component";
import {CreateTrainerComponent} from "./coach/trainers/create-trainer/create-trainer.component";
import {EditTrainerComponent} from "./coach/trainers/edit-trainer/edit-trainer.component";
import {TrainerProgramComponent} from "./coach/trainers/edit-trainer/trainer-program/trainer-program.component";
import {EditWorkoutComponent} from "./coach/workouts/edit-workout/edit-workout.component";
import { ProfileComponent } from './trainer/profile/profile.component';
import { CurrentProgramComponent } from './trainer/program/current-program/current-program.component';
import {ProgramComponent} from "./trainer/program/program.component";
import { RmComponent } from './trainer/program/rm/rm.component';

const routes: Routes = [
  {path: 'welcome', component: WelcomeComponent},
  {path: 'coach', component: CoachComponent},
  {path: 'programs', component: ProgramsComponent},
  {path: 'create-program', component: CreateProgramComponent},
  {path: 'workouts', component: WorkoutsComponent},
  {path: 'create-workout', component: CreateWorkoutComponent},
  {path: 'edit-workout/:id', component: EditWorkoutComponent},
  {path: 'exercises', component: ExercisesComponent},
  {path: 'create-exercise', component: CreateExerciseComponent},
  {path: 'edit-exercise/:id', component: EditExerciseComponent},
  {path: 'trainers', component: TrainersComponent},
  {path: 'create-trainer', component: CreateTrainerComponent},
  {path: 'edit-trainer/:id', component: EditTrainerComponent},
  {path: 'trainer-program/:id', component: TrainerProgramComponent},
  {path: 'edit-program/:id', component: EditProgramComponent},
  {path: 'program', component: ProgramComponent},
  {path: 'profile', component: ProfileComponent},
  {path: 'rm', component: RmComponent},
  {path: 'current-program', component: CurrentProgramComponent},
  {path: '', redirectTo: '/welcome', pathMatch: 'full'},
  {path: '*', redirectTo: '/welcome', pathMatch: 'full'},
  {path: '**', redirectTo: '/welcome', pathMatch: 'full'},
    ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {}
export const routingComponents = [CoachComponent]
