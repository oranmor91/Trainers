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
import { EditProgramComponent } from './coach/programs/edit-program/edit-program.component';
import {TrainersComponent} from "./coach/trainers/trainers.component";
import {CreateTrainerComponent} from "./coach/trainers/create-trainer/create-trainer.component";
import {EditTrainerComponent} from "./coach/trainers/edit-trainer/edit-trainer.component";
import {TrainerProgramComponent} from "./coach/trainers/edit-trainer/trainer-program/trainer-program.component";
import {EditWorkoutComponent} from "./coach/workouts/edit-workout/edit-workout.component";

const routes: Routes = [
  {path: 'welcome', component: WelcomeComponent},
  {path: 'coach', component: CoachComponent},
  {path: 'programs', component: ProgramsComponent},
  {path: 'create-program', component: CreateProgramComponent},
  {path: 'workouts', component: WorkoutsComponent},
  {path: 'create-workout', component: CreateWorkoutComponent},
  {path: 'edit-workout', component: EditWorkoutComponent},
  {path: 'exercises', component: ExercisesComponent},
  {path: 'create-exercise', component: CreateExerciseComponent},
  {path: 'trainers', component: TrainersComponent},
  {path: 'create-trainer', component: CreateTrainerComponent},
  {path: 'edit-trainer', component: EditTrainerComponent},
  {path: 'trainer-program', component: TrainerProgramComponent},
  {path: 'edit-program/:id', component: EditProgramComponent},
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
