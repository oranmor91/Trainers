import { PROGRAM_DATA } from './programData.model';
import { RM_DATA } from './rmData.model';
export class PROGRAM {
  id:number;
  trainerId:number;
  programDefId:number;
  name:string = '';
  description:string = '';
  notes:string = '';
  startDate:Date;
  data:PROGRAM_DATA;
  rmData:RM_DATA[];

}
