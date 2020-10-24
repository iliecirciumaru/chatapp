export class BaseService {
  protected handleError(responseError: any): Promise<any> {
    console.error('An error occurred', responseError);
    return Promise.reject(responseError.error || responseError.message || responseError);
  }
}
