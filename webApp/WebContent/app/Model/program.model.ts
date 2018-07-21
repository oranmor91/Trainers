import { WORKOUT } from './workout.model';
export class PROGRAM {
  programId:number = 0;
  programName:string = '';
  programTarget:string = '';
  programNote:string = '';
  numOfExercises:number;
  workouts: [WORKOUT];
}