import {GENDER} from "./gender.model";

export class TRAINER {
  trainerId:number = 0;
  firstName:string = '';
  lastName:string = '';
  password:string = '';
  gender:GENDER;
  birthDay:Date;
  phoneNumber:string;
  email:string;
  address:string;
  height:number;
  weight:number;
  numOfExperience:number;

}