export default class Event {
  private _id: number;
  private _firstName: string
  private _title: string;
  private _city: string;
  private _street: string;
  private _house: string;


  constructor(id: number, firstName: string, title: string, city: string, street: string, house: string) {
    this._id = id;
    this._firstName = firstName;
    this._title = title;
    this._city = city;
    this._street = street;
    this._house = house;
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get firstName(): string {
    return this._firstName;
  }

  set firstName(value: string) {
    this._firstName = value;
  }

  get title(): string {
    return this._title;
  }

  set title(value: string) {
    this._title = value;
  }

  get city(): string {
    return this._city;
  }

  set city(value: string) {
    this._city = value;
  }

  get street(): string {
    return this._street;
  }

  set street(value: string) {
    this._street = value;
  }

  get house(): string {
    return this._house;
  }

  set house(value: string) {
    this._house = value;
  }
}
